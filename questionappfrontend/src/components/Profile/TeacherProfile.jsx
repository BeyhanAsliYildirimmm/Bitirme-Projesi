import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import { useNavigate, useLocation } from 'react-router-dom';
import { Container, Grid, Typography, CardContent, CardMedia, Card, CardActionArea, Grow } from "@material-ui/core";
import { AiFillDelete } from 'react-icons/ai';
import React, { useState, useEffect } from "react";
import CustomTimeline, { CustomTimelineSeparator } from "../Timeline/Timeline";
import resumeData from "../resumeData";
import TimelineItem from "@material-ui/lab/TimelineItem";
import TimelineContent from "@material-ui/lab/TimelineContent";
import CustomButton from "../Buttons/UpdateButton";
import AutorenewIcon from '@mui/icons-material/Autorenew';
import './Profile.css';

const CustomTimelineItem = ({ title, text, link }) => (
  <TimelineItem>
    <CustomTimelineSeparator />
    <TimelineContent className="timeline_content">
      {link ? (
        <Typography className="timelineItem_text">
          <span>{title}:</span>{" "}
          <a href={link} target="_blank" rel="noopener noreferrer">
            {text}
          </a>
        </Typography>
      ) : (
        <Typography className="timelineItem_text">
          <span>{title}:</span> {text}
        </Typography>
      )}
    </TimelineContent>
  </TimelineItem>
);

const TeacherProfile = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const state = location.state;
  const teacher = state?.dataTeacherDetail?.teacherId;
  const [responseImage, setResponseImage] = useState([]);
  console.log(state?.dataStudentDetail?.responseImages)
  useEffect(() => {
    setResponseImage(state?.dataTeacherDetail?.responseImages || []);
  }, [state?.dataTeacherDetail?.responseImages]);

  return (
    <Container className="top_60">
      <Grid container spacing={7}>
        <Grid item xs={12} sm={12} md={4} lg={3}>
          <div className="profile container_shadow">
            <div className="profile_name">
              <Typography className="name">{state?.dataTeacherDetail?.fistName}</Typography>
              <Typography className="title">{state?.dataTeacherDetail?.lastName}</Typography>
            </div>
            <figure className="profile_image">
              <img src={state?.dataTeacherDetail?.imageUrl} alt="Profile" />
            </figure>
            <div className="profile_information">
              <CustomTimeline icon={<AccountCircleIcon />}>
                <CustomTimelineItem title='Name' text={state?.dataTeacherDetail?.fistName} />
                <CustomTimelineItem title='Title' text={state?.dataTeacherDetail?.lastName} />
                <CustomTimelineItem title='Email' text={state?.dataTeacherDetail?.email} />
                <CustomTimelineItem title='Birthday' text={state?.dataTeacherDetail?.birthday} />
                {Object.keys(resumeData.socials).map((key) => (
                  <CustomTimelineItem
                    key={key}
                    title={key}
                    text={state?.dataStudentDetail?.instagram}
                    link={resumeData.socials[key].link}
                  />
                ))}
              </CustomTimeline>
              <div className='button_container'>
                <CustomButton text={'Güncelle'} icon={<AutorenewIcon />} />
              </div>
            </div>
          </div>
        </Grid>
        <Grid item xs>
          <div className="main_content">
            <Grid container className="section pb_45 pt_45">
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
            <AiFillDelete className="deleteIcon" />
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
  );
}

export default TeacherProfile;
