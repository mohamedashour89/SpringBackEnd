import React, { useEffect, useState } from 'react';
import { Todo } from '../types/todo';
import { api } from '../services/api';
import './TodoList.css';  // Add this import


const TodoList: React.FC = () => {
    // State for todos list and form data
    const [todos, setTodos] = useState<Todo[]>([]);
    const [newTodo, setNewTodo] = useState<Todo>({
        title: '',
        description: '',
        assigner: '',
        assignee: '',
        targetDate: new Date().toISOString().split('T')[0], // Current date in YYYY-MM-DD format
        status: ''
    });

    useEffect(() => {
        loadTodos();
    }, []);

    const loadTodos = async () => {
        try {
            const data = await api.getAllTodos();
            setTodos(data);
        } catch (error) {
            console.error('Error loading todos:', error);
        }
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await api.createTodo(newTodo);
            // Reset form
            setNewTodo({
                title: '',
                description: '',
                assigner: '',
                assignee: '',
                targetDate: new Date().toISOString().split('T')[0],
                status: ''
            });
            loadTodos(); // Refresh the list
        } catch (error) {
            console.error('Error creating todo:', error);
        }
    };

    return (
        <div>
            <h1>Todo List</h1>
            
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="title">Title:</label>
                    <input
                        id="title"
                        type="text"
                        value={newTodo.title}
                        onChange={(e) => setNewTodo({ ...newTodo, title: e.target.value })}
                        required
                    />
                </div>

                <div>
                    <label htmlFor="description">Description:</label>
                    <textarea
                        id="description"
                        value={newTodo.description}
                        onChange={(e) => setNewTodo({ ...newTodo, description: e.target.value })}
                        required
                    />
                </div>

                <div>
                    <label htmlFor="assigner">Assigner:</label>
                    <input
                        id="assigner"
                        type="text"
                        value={newTodo.assigner}
                        onChange={(e) => setNewTodo({ ...newTodo, assigner: e.target.value })}
                        required
                    />
                </div>

                <div>
                    <label htmlFor="assignee">Assignee:</label>
                    <input
                        id="assignee"
                        type="text"
                        value={newTodo.assignee}
                        onChange={(e) => setNewTodo({ ...newTodo, assignee: e.target.value })}
                        required
                    />
                </div>

                <div>
                    <label htmlFor="targetDate">Target Date:</label>
                    <input
                        id="targetDate"
                        type="date"
                        value={newTodo.targetDate}
                        onChange={(e) => setNewTodo({ ...newTodo, targetDate: e.target.value })}
                        required
                    />
                </div>

                <div>
                    <label htmlFor="status">Status:</label>
                    <select
                        id="status"
                        value={newTodo.status}
                        onChange={(e) => setNewTodo({ ...newTodo, status: e.target.value })}
                        required
                    >
                        <option value="">Select Status</option>
                        <option value="PENDING">Pending</option>
                        <option value="IN_PROGRESS">In Progress</option>
                        <option value="COMPLETED">Completed</option>
                    </select>
                </div>

                <button type="submit">Add Todo</button>
            </form>

            <table style={{ width: '100%', marginTop: '20px', borderCollapse: 'collapse' }}>
                <thead>
                    <tr>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Title</th>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Description</th>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Assigner</th>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Assignee</th>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Target Date</th>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {todos.map((todo) => (
                        <tr key={todo.id}>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>{todo.title}</td>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>{todo.description}</td>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>{todo.assigner}</td>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>{todo.assignee}</td>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>{todo.targetDate}</td>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>{todo.status}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default TodoList;