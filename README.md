# Back End
Base API Link
https://cking-watermyplants.herokuapp.com

Endpoints ->

| Request | URL               | Description                 |
| ------- | ----------------- | --------------------------- |
| POST    | /users/user       | Registers new User          |
| POST    | /login            | Login as an existing User   |
| GET     | /users/{userid}   | Get User by id              |
| PUT     | /users/{userid}   | Update User by id           |
| GET     | /plants/{userid}  | Get all Plants by Userid    |
| PUT     | /plants/{plantid} | Edit Plant by Plantid       |
| POST    | /plants/{userid}  | Save New Plant by Userid    |
| DELETE  | /plants/{plantid} | Delete by Plant by id       |

Table Requirements ->

Users

| Name         | Type    | Required | Unique | Notes                     |
| ------------ | ------- | -------- | ------ | ------------------------- |
| id           | Integer | Yes      | Yes    | User id (auto generated)  |
| username     | String  | Yes      | Yes    | Users Username            |
| password     | String  | Yes      | No     | Users Password            |
| primaryemail | String  | Yes      | Yes    | Users Email               |
| phone        | String  | No       | Yes    | Users Phone Number        |

Plants

| Name         | Type    | Required | Unique | Notes                      |
| ------------ | ------- | -------- | ------ | -------------------------- |
| id           | integer | Yes      | Yes    | Plants id (auto generated) |
| nickname     | string  | Yes      | No     | Plants Nickname            |
| species      | string  | Yes      | No     | Plants Species             |
| h2oFrequency | integer | No       | No     | Plants Water Frequency     |
| photo        | string  | No       | No     | Plants Picture or Location |





EXAMPLE FOR LOGGING IN WITH OAUTH2
Oauth2 requires authorization header to include ->

```
const login = e => {
    e.preventDefault();
    axios.post('http://localhost:2019/login', `grant_type=password&username=${credentials.username}&password=${credentials.password}`, {
      headers: {
        // btoa is converting our client id/client secret into base64
        Authorization: `Basic ${btoa('lambda-client:lambda-secret')}`,
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    })
    .then(res => {
      console.log(res.data)
      localStorage.setItem('token', res.data.access_token);
      props.history.push('/');
    })
  }


```

EXAMPLE WITH AXIOSWITHAUTH

```
export const axiosWithAuth = () => {
  const token = window.localStorage.getItem("token"); 

  return axios.create({
    headers: {
      Authorization: `Bearer ${token}`
    },
    baseURL: 'http://localhost:2019'
  });
};

```









