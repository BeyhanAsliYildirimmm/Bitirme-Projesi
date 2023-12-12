import React, { useState } from "react";
import {Link,useNavigate} from 'react-router-dom';
import studentService from "../Service/student.service";
import './studentStyle.css';
import Navbar from "../Navbar/Navbar";
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
const AddStudent = () => {

    const navigate = useNavigate();
    const [show, setShow] = useState(false);
    const [student,setStudent]=useState({
        fistName: "",
        lastName: "",
        email: "",
        password: "",
    });

    const handleChange = (e) => {
      
        const value = e.target.value;
        setStudent({...student, [e.target.name]: value });
    }
    const handleClose = () => setShow(false);

    const submitStudent =(e)=>{
       
        e.preventDefault();
      const cevap= studentService.saveStudent(student);
       cevap.then(function(value){
        
        if(value===true){
          navigate('/singInStudent');
          
        }
        else if(value===false){
            setShow(true);
        }
      });
     

    };
    return(
        <>
        <Navbar></Navbar>
        <div className="containerr">
            <div className="row">
            <video src='/videos/back.mp4' autoPlay loop muted />
                <div className="col-md-6 offset-md-3"> 
                    <div className="card">
                        <div className="card-body">
                            <form onSubmit={(e) => submitStudent(e)}>
                                <div className="mb-3">
                                    <label id="name">Ad</label>
                                    <input
                                    type="text"
                                    className="form-control"
                                    name="fistName"
                                    value={student.fistName}
                                    onChange={(e)=>handleChange(e)}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label id="lastname">Soyad</label>
                                    <input
                                    type="text"
                                    className="form-control"
                                    name="lastName"
                                    value={student.lastName}
                                    onChange={(e)=>handleChange(e)}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label id="email">Email</label>
                                    <input
                                    type="text"
                                    className="form-control"
                                    name="email"
                                    value={student.email}
                                    onChange={(e)=>handleChange(e)}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label id="password">Şifre</label>
                                    <input
                                    type="password"
                                    className="form-control"
                                    name="password"
                                    value={student.password}
                                    onChange={(e)=>handleChange(e)}
                                    />
                                </div>

                                    <button type="submit" className="buttonLoginn">Sing Up</button>
                                   <Link to ="/singInStudent"  className="buttonRegisterr">Sing In </Link>
                               
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <Modal show={show} >
        <Modal.Header closeButton>
          <Modal.Title>Modal heading</Modal.Title>
        </Modal.Header>
        <Modal.Body>Bir şeyler yanlış gitti tekrar deneyiniz.!</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </>
    );
};
export default AddStudent;