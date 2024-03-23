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
    const [password, setPassword] = useState('')
    const [showSuccessMsg, setShowSuccessMsg] = useState(false)
    const [showErrorMsg, setShowErrorMsg] = useState(false)

    function handleUsernameChange(event) {
        setUsername(event.target.value)
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value)
    }

    function handleSubmit() {
        if(username === 'Ujjawal' && password === '123') {
            setShowSuccessMsg(true)
            setShowErrorMsg(false)
        }
        else {
            setShowSuccessMsg(false)
            setShowErrorMsg(true)
        }
    }

    function SuccessMsg() {
        if(showSuccessMsg) {
            return <div className='sucessMessage'>Authenticated Successfully</div>
        }
        
        return null
    }
    
    function ErrorMsg() {
        if(showErrorMsg) {
            return <div className='errorMessage'>Authenticated Failed. Please check creds.</div>
        }
        
        return null
    }

    return (
        <div className="Login">
            <div className="LoginForm">
                <SuccessMsg/>
                <ErrorMsg/>
                <div>
                    <label>Username</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    )
}