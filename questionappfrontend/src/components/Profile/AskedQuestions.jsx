import React, {useState} from "react";
import './AskedQuestions.css'
import { CardContent, DialogActions, Grid } from "@mui/material";
import resumeData from "../resumeData";
import {CardMedia,CardActionArea,Card,Grow }from "@mui/material";
import { DialogTitle, Typography } from "@material-ui/core";
import Dialog from '@mui/material/Dialog';
import { AiFillDelete } from 'react-icons/ai';
import { AiOutlineCloseCircle } from 'react-icons/ai';



const AskedQuestions = () =>{

    const [projectDetail,setProjectDetail] = useState(false);

 
    return(
     <Grid container className="section pb_45 pt_45" >  
      <Grid item xs={12} >
        <Grid container spacing={3}>
        {resumeData.projects.map((project) => (
            <Grid item>
                <Grow in timeout={1000}>
                    <Card className="customCard">
                        <CardActionArea>
                            <CardMedia className="customCard_image"
                            onClick={() =>setProjectDetail(project) }
                            
                            image={project.image} 
                             />
                            <CardContent>
                                <AiFillDelete className="deleteIcon" />    
                            </CardContent>
                        </CardActionArea>
                    </Card>
                </Grow>
            </Grid>
            ))}
        </Grid>
     </Grid>
     
     <Dialog open={projectDetail} onClose={() => (setProjectDetail(false))} className="projectDetail" maxWidth={"sm"} fullWidth>
         <AiOutlineCloseCircle className="closeIcon" onClick={() => setProjectDetail(false)} />
         <img src={projectDetail.image} alt="" className="projectDetail_image" />
         <DialogActions>
            kfcdfk
         </DialogActions>
      </Dialog>
    </Grid>  
    );
};
export default AskedQuestions;