async function GetSensorData() {
  let json = null;
  try {
    const response =  await fetch(`http://localhost:5000/sensor/list`);

    if(response.status != 200) {
      console.log(response);
    } else {
      json = await response.json();
    }
  } catch (error) {
    console.log('Error found on api:');
    console.log(error);
  }
  return json;
}

export default GetSensorData;