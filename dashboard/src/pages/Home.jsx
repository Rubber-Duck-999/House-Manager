import React from 'react';
import {styled} from '@mui/material/styles';
import { Grid, Paper, Typography } from '@mui/material';

const Item = styled(Paper)(({theme}) => ({
  backgroundColor: 'dark',
  padding: theme.spacing(1),
  margin: theme.spacing(0,1),
  textAlign: 'center',
  color: 'blue',
}));

const Home = () => (
    <Grid spacing={1} container direction="column">
      <Grid xs={12} alignItems="center">
      </Grid>
    </Grid>
  );
export default Home;