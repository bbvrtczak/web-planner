import React from 'react';
import { Task } from '../types';

interface TaskListProps {
    tasks: Task[];
}

const TaskList: React.FC<TaskListProps> = ({ tasks }) => {
    return (
    <ul>
        {tasks.map(task => (
        <li key={task.id}>
            <h3>{task.name}</h3>
            <p>Start Date: {formatDate(task.startDate)}</p>
            <p>End Date: {formatDate(task.endDate)}</p>
        </li>
        ))}
    </ul>
    );
};

const formatDate = (dateArray: number[]): string => {
    const [year, month, day, hour, minute] = dateArray;
    const formattedDate = new Date(year, month - 1, day, hour, minute).toLocaleString();
    return formattedDate;
};

export default TaskList;
