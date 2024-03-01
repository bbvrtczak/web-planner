// import axios from "axios";
// import React from "react";

// interface Task {
//     id: string;
//     name: string;
// }

// const apiURL = "http://localhost:8081/api/tasks";

// export default function Tasks() {
//     const [task, setTask] = React.useState(null);

//     React.useEffect(() => {
//         axios.get(apiURL).then((response) => {
//             setTask(response.data);
//         });
//     }, []);

//     if (!task) return null;

//     return (
//         <div>
//         <h1>{task.id}</h1>
//         <p>{task.name}</p>
//         </div>
//     );
// }