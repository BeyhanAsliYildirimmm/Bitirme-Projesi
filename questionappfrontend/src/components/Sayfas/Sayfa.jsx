import { Container,Grid } from "@material-ui/core";
import { useLocation, useNavigate } from "react-router-dom";
import { CardMedia, CardActionArea, Card, Grow } from "@mui/material";
import { CardContent } from "@mui/material";
import { AiFillDelete } from 'react-icons/ai';
import Navbar from 'react-bootstrap/Navbar';
import Modal from 'react-bootstrap/Modal';
import React, { useState, useRef, useEffect } from "react";
import '../Sayfas/Sayfa.css';
import { CgProfile } from 'react-icons/cg';
import studentService from "../Service/student.service";

function ContainerOutsideExample(props) {
  const [modalIsOpen, setIsOpen] = React.useState(false);

  function openModal() {
    setIsOpen(true);
  }

  function closeModal() {
    setIsOpen(false);
  }

  const location = useLocation();
  const [responseImage, setResponseImage] = useState([]);
  const state = location.state;
  const studentId = state.dataStudent.studentId;

  useEffect(() => {
    setResponseImage(state.dataStudent.responseData);
  }, [state.dataStudent.responseData]);

  const dataStudentDetail = {
    email: "",
    fistName: "",
    id: "",
    lastName: "",
    imageUrl: "",
    birthday: "",
    linkedIn: "",
    instagram: "",
    studentId:"",
    responseImages:[]
  }

  const navigate = useNavigate();
  const [image, setImage] = useState(null);
  const [description, setDescription] = useState("");
  const inputRef = useRef(null);

  const submit = async (event) => {
    event.preventDefault();

    const formData = new FormData();
    formData.append("file", image, image.name);
    formData.append("description", description);
    formData.append("studentId", studentId);
    const result = studentService.questionLoad(formData)
  };

  const handleImageChange = (event) => {
    const file = event.target.files[0];
    setImage(file);
  };

  const handleImageClick = () => {
    inputRef.current.click();
  };

  const deleteImage = (imageName) => {
    // İlgili resmin `name` değerini kullanarak işlemler yapabilirsiniz
    console.log("Delete image:", imageName);
  
    // Örneğin, servise silme isteği gönderebilirsiniz
   // const response = studentService.deleteStudentQuestion(imageName);
  };
  function handleClickIcon() {
    const response = studentService.getStudentDetailById(studentId);
   
     dataStudentDetail.studentId= state.dataStudent.studentId;
     dataStudentDetail.responseImages=responseImage;
    response.then((res) => {
      dataStudentDetail.email = res.data.email;
      dataStudentDetail.birthday = res.data.birthday;
      dataStudentDetail.fistName = res.data.fistName;
      dataStudentDetail.imageUrl = res.data.imageUrl;
      dataStudentDetail.lastName = res.data.lastName;
      dataStudentDetail.instagram = res.data.instagram;
      dataStudentDetail.linkedIn = res.data.linkedIn;
    
     navigate(
        '/studentProfile', { state: { dataStudentDetail } })
    });
    console.log(dataStudentDetail)

  }

  return (
    <>
      <div className='frame'>
        <div>
          <Navbar className='navbar2' expand="lg" variant="light" bg="light">
            <Container>
              <button onClick={openModal}>Yükle</button>
              <CgProfile className='customerProfile' onClick={handleClickIcon} />
            </Container>
          </Navbar>
          <Container className="top_60">
            <Grid container spacing={7}>

              <Grid item xs>
                <div className="main_content">
                  <Grid container className="section pb_45 pt_45" >
                    <Grid item xs={12}>
                      <Grid container spacing={3}>
                        {responseImage.map((imageData, index) => (
                          <Grid item key={index}>
                            <Grow in timeout={1000}>
                              <Card className="customCard">
                                <CardActionArea>
                                  <CardMedia
                                    className="customCard_image"
                                    image={`data:image/png;base64, ${imageData}`}
                                  />
                                  <CardContent>
                                    <AiFillDelete className="deleteIcon"  onClick={() => deleteImage(imageData.name)}/>
                                  </CardContent>
                                </CardActionArea>
                              </Card>
                            </Grow>
                          </Grid>
                        ))}
                      </Grid>
                    </Grid>


                  </Grid>
                </div>
              </Grid>
            </Grid>
          </Container>
        </div>
      </div>


      <Modal show={modalIsOpen} >
        <Modal.Header onClick={closeModal} closeButton>
          <Modal.Title>Lütfen Sorunuzu Yükleyin</Modal.Title>
        </Modal.Header>
        <Modal.Body>

          <div className="App">
            <form className="fileForm" onSubmit={submit}>
              <div onClick={handleImageClick}>
                {image ? (
                  <img src={URL.createObjectURL(image)} className="imgFile" alt="Uploaded" />
                ) : (
                  <img src="./upload.png" className="imgFile" alt="Upload" />
                )}
                <input
                  onChange={handleImageChange}
                  type="file"
                  accept="image/*"
                  hidden
                  ref={inputRef}
                />
              </div>
              <input
                onChange={(e) => setDescription(e.target.value)}
                type="text"
                className="description"
              />
              <button type="submit" className="btn">
                Submit
              </button>
            </form>
          </div>

        </Modal.Body>
      </Modal>

    </>
  );
}
export default ContainerOutsideExample;
