import { Task } from '../types';

export const fetchTasks = async (): Promise<Task[]> => {
    try {
    const response = await fetch('http://localhost:8081/api/tasks');
    if (!response.ok) {
        throw new Error('Failed to fetch tasks');
    }
    const responseData = await response.json();
    if (Array.isArray(responseData.tasks)) {
        return responseData.tasks;
    } else {
        throw new Error('Tasks data is not an array');
    }
    } catch (error) {
    console.error('Error fetching tasks:', error);
    return [];
    }
};
