import { Todo} from '../types/todo';

const BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';

export const api = {
    // geting all registedred todo
    getAllTodos: async (): Promise<Todo[]> => {
        const response = await fetch(`${BASE_URL}/todos`);
        return response.json(); 
    }, 

    // Creating new todo
    createTodo: async (todo: Todo): Promise<Todo> => {
        const response = await fetch(`${BASE_URL}/todos`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(todo)
        });
        return response.json();
    },



}