import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import TasksComponent from './components/Tasks.tsx'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <App />
    {/* <TasksComponent /> */}
  </React.StrictMode>,
)
