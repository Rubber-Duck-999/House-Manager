async function GetDeviceData() {
  let json = null;
  try {
    const response =  await fetch(`http://localhost:5000/device/list`);
    if(response.status != 200) {
      console.log(`Response (Devices): ${response}`);
    } else {
      json = await response.json();
    }
  } catch (error) {
    console.log('Error found on api:');
    console.log(error);
  }
  return json;
}

export default GetDeviceData;