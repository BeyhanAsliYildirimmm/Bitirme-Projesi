import React, {useState} from 'react';
import {Link,useNavigate} from 'react-router-dom';
import teacherService from "../Service/teacher.service";
import './teacherStyle.css'
import Navbar from '../Navbar/Navbar';

const SingUpTeacher = () =>{
 
   const navigate = useNavigate();
   const [teacher,setTeacher]=useState({
        fistName: "",
        lastName: "",
        brans:"",
        email: "",
        password: ""
       
    });
    const handleChangee = (e) => {
       const value = e.target.value;
       setTeacher({...teacher, [e.target.name]: value });
    }
    const submitTeacher =(e)=>{

            console.log(teacher);
            e.preventDefault();
            teacherService.saveTeacher(teacher);
            navigate('/singInTeacher');
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
                            <form onSubmit={(e) => submitTeacher(e)}>
                                <div className="mb-3">
                                    <label id='name'>Ad</label>
                                    <input
                                    type="text"
                                    className="form-control"
                                    name="fistName"
                                    value={teacher.fistName}
                                    onChange={(e)=>handleChangee(e)}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label id='lastname'>Soyad</label>
                                    <input
                                    type="text"
                                    className="form-control"
                                    name="lastName"
                                    value={teacher.lastName}
                                    onChange={(e)=>handleChangee(e)}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label id='brans'>Branş</label>
                                    <input
                                    type="text"
                                    className="form-control"
                                    name="brans"   
                                    value={teacher.brans}
                                    onChange={(e)=>handleChangee(e)}                              
                                    />
                                </div>
                                <div className="mb-3">
                                    <label id='email'>Email</label>
                                    <input
                                    type="text"
                                    className="form-control"
                                    name="email"    
                                    value={teacher.email}
                                    onChange={(e)=>handleChangee(e)}                            
                                    />
                                </div>
                                <div className="mb-3">
                                    <label id='password'>Şifre</label>
                                    <input
                                    type="password"
                                    className="form-control"
                                    name="password" 
                                    value={teacher.password}
                                    onChange={(e)=>handleChangee(e)}                                
                                    />
                                </div>
                                    <button type='submit' className="buttonRegister">Sing Up</button>
                                    <Link to="/singInTeacher"  className="buttonLogin">Sing In</Link>
                                
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </>
    );
};
export default  SingUpTeacher;
