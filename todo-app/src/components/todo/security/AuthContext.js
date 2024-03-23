///Create a context

import { createContext, useContext, useState } from "react";

export const AuthContext =  createContext()

export const useAuth = () => useContext(AuthContext)

//Share the created context with other components

export default function AuthProvider({children}) {

    //Put some state in Context
    const [isAuthenticated, setAuthenticated] = useState(false)

    function login(username, password) {
        if (username === 'Ujjawal' && password === '123') {
            setAuthenticated(true)
            return true
        }
        else {
            setAuthenticated(false)
            return false
        }
    }

    function logout() {
        setAuthenticated(false)
    }

    return (
        <AuthContext.Provider value={ {isAuthenticated, login, logout } }>
            {children}
        </AuthContext.Provider>
    )
}