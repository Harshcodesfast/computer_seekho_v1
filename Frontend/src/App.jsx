import { useEffect, useState } from "react";
import api from "./services/api";

function App() {

  const [message, setMessage] = useState("");

  useEffect(() => {

    api.get("/health")
      .then((response) => {
        setMessage(response.data);
      })
      .catch((error) => {
        console.log(error);
      });

  }, []);

  return (
    <div>

      <h1>Computer Seekho v1</h1>

      <h2>{message}</h2>

    </div>
  );
}

export default App;
//hello