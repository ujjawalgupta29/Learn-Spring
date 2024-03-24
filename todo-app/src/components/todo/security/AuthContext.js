///Create a context

import { createContext, useContext, useState } from "react";

export const AuthContext =  createContext()

export const useAuth = () => useContext(AuthContext)

//Share the created context with other components

export default function AuthProvider({children}) {

    //Put some state in Context
    const [isAuthenticated, setAuthenticated] = useState(false)
    const [username, setUsername] = useState(null)

    function login(username, password) {
        if (username === 'Ujjawal' && password === '123') {
            setUsername(username)
            setAuthenticated(true)
            return true
        }
        else {
            setUsername(null)
            setAuthenticated(false)
            return false
        }
    }

    function logout() {
        setAuthenticated(false)
    }

    return (
        <AuthContext.Provider value={ {isAuthenticated, login, logout, username } }>
            {children}
        </AuthContext.Provider>
    )
}