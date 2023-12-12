import './App.css';
import Register from './components/Student/Register';
import Login from './components/Student/Login';
import Home from './components/Home';
import {Routes,Route} from 'react-router-dom';
import TeacherLogin from './components/Teacher/teacherLogin';
import TeacherRegister from './components/Teacher/teacherRegister';
import Frame from './components/Frame';
import StudentProfile from './components/Profile/StudentProfile';
import AskedQuestions from './components/Profile/AskedQuestions';
import ContainerOutsideExample from './components/Sayfas/Sayfa';
import TeacherProfile from './components/Profile/TeacherProfile';
import { ImageOutlined } from '@mui/icons-material';
import ContainerOutsideExampleTwo from './components/Sayfas/TeacherSayfa';

function App() {
  
  return (
    <div className="App">
    
   <Routes>
    <Route path='/' element={<Home />}/>
    <Route path='/studentRegister' element={<Register />}/>
    <Route path='/singInStudent' element={<Login />}/>
    <Route path='/singInTeacher' element={<TeacherLogin />}/>
    <Route path='/singUpTeacher' element={<TeacherRegister />}/>
    <Route path='/sayfa' element={<ContainerOutsideExample />}/>
    <Route path='/teacherSayfa' element={<ContainerOutsideExampleTwo />}/>

    <Route path='/frame' element={<Frame />} />
    <Route path='/studentProfile' element={<StudentProfile />} />
    <Route path='/teacherProfile' element={<TeacherProfile />} />
    <Route path='/askedQuestions' element={<AskedQuestions />} />
   

   </Routes>
    </div>
  );
}

export default App;
