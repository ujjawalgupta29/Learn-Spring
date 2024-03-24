///Create a context

import { createContext, useContext, useState } from "react";
import { executeJwtAuthenticationService } from "../api/AuthenticationService";
import { apiClient } from "../api/ApiClient";

export const AuthContext =  createContext()

export const useAuth = () => useContext(AuthContext)

//Share the created context with other components

export default function AuthProvider({children}) {

    //Put some state in Context
    const [isAuthenticated, setAuthenticated] = useState(false)
    const [username, setUsername] = useState(null)
    const [token, setToken] = useState(null)

    // async function login(username, password) {
    //     const baToken = 'Basic ' + window.btoa(username + ":" + password)
    //     try {
    //         const response = await executeBasicAuthenticationService(baToken)

    //         if (response.status == 200) {
    //             setUsername(username)
    //             setAuthenticated(true)
    //             setToken(baToken)

    //             apiClient.interceptors.request.use(
    //                 (config) => {
    //                     config.headers.Authorization = baToken
    //                     return config
    //                 }
    //             )

    //             return true
    //         }
    //         else {
    //             logout()
    //             return false
    //         }
    //     } catch(error) {
    //         logout()
    //         return false
    //     }
    // }


    async function login(username, password) {
        try {
            const response = await executeJwtAuthenticationService(username, password)

            if (response.status == 200) {
                const jwtToken = 'Bearer ' + response.data.token
                setUsername(username)
                setAuthenticated(true)
                setToken(jwtToken)

                apiClient.interceptors.request.use(
                    (config) => {
                        config.headers.Authorization = jwtToken
                        return config
                    }
                )

                return true
            }
            else {
                logout()
                return false
            }
        } catch(error) {
            logout()
            return false
        }
    }

    function logout() {
        setUsername(null)
        setAuthenticated(false)
        setToken(null)
    }

    return (
        <AuthContext.Provider value={ {isAuthenticated, login, logout, username, token } }>
            {children}
        </AuthContext.Provider>
    )
}