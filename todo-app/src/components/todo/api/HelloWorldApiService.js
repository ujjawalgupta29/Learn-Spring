import { apiClient } from './ApiClient';

export function retrieveHelloWorldBean() {
    return apiClient.get('/hello-world-bean')
}

export function retrieveHelloWorldPathVariable(username) {
    return apiClient.get(`/hello-world/path-variable/${username}`)
}

