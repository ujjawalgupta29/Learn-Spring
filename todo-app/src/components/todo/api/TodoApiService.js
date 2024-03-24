import axios from 'axios';

const apiClient =  axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
)


export function retrieveAllTodosForUserApi(username) {
    return apiClient.get(`/users/${username}/todos`)
}

export function deleteTodoApi(username, id) {
    return apiClient.delete(`/users/${username}/todos/${id}`)
}

export function retrieveTodo(username, id) {
    return apiClient.get(`/users/${username}/todos/${id}`)
}