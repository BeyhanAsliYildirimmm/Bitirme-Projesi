import axios from "axios";

const BASE_API_URL="http://localhost:8080/student";


class StudentService{
 
  constructor() {
    this.base64Image = null;
  }
    saveStudent(student){
     
     const response= axios.post(BASE_API_URL+"/save",student)
     .then(res =>  res.status === 201 ? true : false)
     .catch(err => false);
     return response;
    }
    async loginStudent(studentLogin){
    
      const response = await axios.post(BASE_API_URL+"/login",studentLogin)
      console.log(response)
     return response;
  }


  async  qestiondowload(studentId) {
    try {
      const response = await axios.get(BASE_API_URL + `/question-download/${studentId}`);
      const imageDataList = response.data;
      return imageDataList;
    } catch (error) {
      console.error('Resim indirme hatası:', error);
      return [];
    }
  }
 
  async  questionLoad(formData) {
    // FormData ile ilgili işlemleri gerçekleştirin ve isteği gönderin
    // ...
    const response = await axios.post(BASE_API_URL + "/question-save", formData);
    return response;
  }
  
 


    getAllStudent(){
        return axios.get(BASE_API_URL+"/getAll");
    }

    getStudentDetailById(id){
    
     
      const response= axios.get(BASE_API_URL+"/user-information/"+id);
      return response;
    }

    deleteStudent(id){
        return axios.get(BASE_API_URL+"/delete/"+id)
    }
    deleteStudentQuestiom(questionName){
      return axios.get(BASE_API_URL+"/image/delete/"+questionName)
  }

    updateStudent(id,student){

        return axios.post(BASE_API_URL+"/update/"+id,student)
    }
}

export default new StudentService();