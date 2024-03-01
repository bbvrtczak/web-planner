import { useState, useEffect } from 'react';
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import './App.css'

interface Task {
  name: string;
  // Add other properties as needed
}

function App() {
  //const [count, setCount] = useState(0)
  const [task, setTask] = useState<Task[]>([]);

  useEffect(() => {
    fetch('http://localhost:8081/api/tasks')
    .then(response => response.json())
    .then(data => {
      setTask(data);
      console.log(data);
    })
    .catch(err => console.log(err))
  }, []);

  return (
    <>
      <div>
        {task.map((task) =>{
          return <p>{task.name}</p>
        })}
      </div>
    </>
  )
}

export default App



  // useEffect(() => {
  //   fetch('http://localhost:8081/api/tasks')
  //       .then((res) => res.json())
  //       .then((data) => {
  //         console.log(data);
  //         setPosts(data);
  //       })
  //       .catch((err) => {
  //         console.log(err.message);
  //       });
  // }, []);


  // return (
  //   <>
  //     <div>
  //       <a href="https://vitejs.dev" target="_blank">
  //         <img src={viteLogo} className="logo" alt="Vite logo" />
  //       </a>
  //       <a href="https://react.dev" target="_blank">
  //         <img src={reactLogo} className="logo react" alt="React logo" />
  //       </a>
  //     </div>
  //     <h1>Vite + React</h1>
  //     <div className="card">
  //       <button onClick={() => setCount((count) => count + 1)}>
  //         count is {count}
  //       </button>
  //       <p>
  //         Edit <code>src/App.tsx</code> and save to test HMR
  //       </p>
  //     </div>
  //     <p className="read-the-docs">
  //       Click on the Vite and React logos to learn more
  //     </p>
  //   </>
  // )