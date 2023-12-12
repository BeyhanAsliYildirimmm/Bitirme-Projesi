import React,{useState} from "react";
import "../Navbar/Navbar-Style.css";
import { FcSearch } from "react-icons/fc";
import { AiOutlineMenu } from "react-icons/ai";
import { AiOutlineClose } from "react-icons/ai";

const Navbar = () =>{

  const [Mobile,setMobile] = useState(false)
return(
<nav className="navbar navbar-expand-lg navbar-dark bg-dark">
  <FcSearch size={25} />
  <button  className='mobile-menu-icon' onClick={() => setMobile(!Mobile)} type="button" >
  {Mobile? <AiOutlineMenu /> :  <AiOutlineClose />}
  </button>
  <div className=" navbar-collapse">
    <ul  className={Mobile ? "navbar-nav mr-auto mt-2 mt-lg-0 nav-links-mobile": 'nav-links navbar-nav mr-auto mt-2 mt-lg-0'} onClick={() => setMobile(false)}   >
      <li className="nav-item active">
        <a className="nav-link"  id="home" href="/">Ana Sayfa</a>
      </li>
      <li className="nav-item">
        <a className="nav-link" id="singin"  href="/singInStudent">Giriş Yap</a>
      </li>
      <li className="nav-item">
        <a className="nav-link " id="singup" href="/singInTeacher" >Üye Ol</a>
      </li>
    </ul>
  
  </div>
</nav>

)
}
export default Navbar