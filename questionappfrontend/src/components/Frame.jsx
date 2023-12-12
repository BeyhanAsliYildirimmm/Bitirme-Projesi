import { Container, Grid } from "@material-ui/core";
import StudentProfile from "./Profile/StudentProfile";
import AskedQuestions from "./Profile/AskedQuestions";
function Frame(){
    return(
      <Container className="top_60">
        <Grid container spacing={7}>
            <Grid item
            xs={12}
            sm={12}
            md={4}
            lg={3} >
             <StudentProfile />
            </Grid>
            <Grid item xs>
              <div className="main_content">
               <AskedQuestions />
              
              </div>
            </Grid>
        </Grid>
      </Container>
    )
}
export default Frame;