import React, { useEffect, useState } from 'react';

interface Task {
  id: number;
  name: string;
  startDate: number[];
  endDate: number[];
}

const App: React.FC = () => {
  const [tasks, setTasks] = useState<Task[]>([]);

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      const response = await fetch('http://localhost:8081/api/tasks');
      if (!response.ok) {
        throw new Error('Failed to fetch tasks');
      }
      const responseData = await response.json();
      console.log('Fetched tasks data:', responseData);

      if (Array.isArray(responseData.tasks)) {
        setTasks(responseData.tasks);
      } else {
        console.error('Tasks data is not an array:', responseData.tasks);
      }
    } catch (error) {
      console.error('Error fetching tasks:', error);
    }
  };

  return (
    <div>
      <h1>Task List</h1>
      <ul>
        {tasks.map(task => (
          <li key={task.id}>
            <h3>{task.name}</h3>
            <p>Start Date: {formatDate(task.startDate)}</p>
            <p>End Date: {formatDate(task.endDate)}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

// Function to format the date array into a string
const formatDate = (dateArray: number[]): string => {
  const [year, month, day, hour, minute] = dateArray;
  const formattedDate = new Date(year, month - 1, day, hour, minute).toLocaleString();
  return formattedDate;
};

export default App;
