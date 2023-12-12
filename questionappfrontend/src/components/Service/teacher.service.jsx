import axios from "axios";

const BASE_API_URL="http://localhost:8080/teacher";

class teacherService{


  saveTeacher(teacher){
     
    const response= axios.post(BASE_API_URL+"/save",teacher)
    .then(res =>  res.status === 201 ? true : false)
    .catch(err => false);
    return response;
   }
   

  async loginTeacher(teacherLogin){
     const response = await axios.post(BASE_API_URL+"/login",teacherLogin)
       return response;
    }
    async  qestiondowload(teacherId) {
      try {
        const response = await axios.get(BASE_API_URL + `/question-download/${teacherId}`);
        const imageDataList = response.data;
        return imageDataList;
      } catch (error) {
        console.error('Resim indirme hatası:', error);
        return [];
      }
    }

    getTeacherDetailById(id){
    
      const response= axios.get(BASE_API_URL+"/user-information/"+id);
      return response;
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

    getStudentById(id){
      return axios.get(BASE_API_URL+"/"+id);
    }

    deleteStudent(id){
        return axios.get(BASE_API_URL+"/delete/"+id)
    }

    updateStudent(id,teacher){

        return axios.post(BASE_API_URL+"/update/"+id,teacher)
    }
  
}
export default new teacherService();