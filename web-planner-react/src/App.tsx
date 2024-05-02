import React, { useEffect, useState } from 'react';
import TaskList from './components/TaskList';
import { fetchTasks } from './services/taskService';
import { Task } from './types';

const App: React.FC = () => {
  const [tasks, setTasks] = useState<Task[]>([]);

  useEffect(() => {
    fetchTasks().then(tasks => setTasks(tasks));
  }, []);

  return (
    <div>
      <h1>Task List</h1>
      <TaskList tasks={tasks} />
    </div>
  );
};

export default App;
