import { useState } from 'react';
import './TodoApp.css';

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <LoginComponent/>
            {/* <WelcomeComponent/> */}
        </div>
    )
}

function LoginComponent() {
    const [username, setUsername] = useState('Ujjawal')
    const [password, setPassword] = useState('Ujjawal')

    function handleUsernameChange(event) {
        setUsername(event.target.value)
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value)
    }

    return (
        <div className="Login">
            <div className="LoginForm">
                <div>
                    <label>Username</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
                </div>
                <div>
                    <button type="button" name="login">Login</button>
                </div>
            </div>
        </div>
    )
}

function WelcomeComponent() {
    return (
        <div className="Login">
            Welcome Component
        </div>
    )
}