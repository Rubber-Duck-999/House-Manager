import React, { useState } from 'react';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import {ValidateMoodData, UpdateMoodData} from '../validators/mood';
import PowerSettingsNewIcon from '@mui/icons-material/PowerSettingsNew';
import Stack from '@mui/material/Stack';

function Mood() {
  let [mood, setState] = useState('');
  React.useEffect(() => {
    (async () => {
      const mood = await ValidateMoodData();
      setState(mood);
    })();
  }, []);
  const updateMood = async (param) => {
    const mood = await UpdateMoodData(param);
    setState(mood);
  };

  return (
    <div>
      <Card>
        <CardContent>
          <Typography align="center" sx={{ mb: 1.5 }} variant="h4" color="text.primary">
            <PowerSettingsNewIcon/> {mood.state} 
          </Typography>
        </CardContent>
        <Stack 
          spacing={5}
          direction="row"
          alignItems="center"
          justifyContent="center"
          padding={1}
        >
          <Button
            size="medium"
            value="ON"
            variant="contained"
            onClick={(e) => updateMood(e.target.value)}
            color="success"
          >ON
          </Button>
          <Button
            size="medium"
            value="OFF"
            variant="contained"
            onClick={(e) => updateMood(e.target.value)}
            color="error"
          >OFF
          </Button>
        </Stack>
      </Card>
    </div>
  );
};

export default Mood;