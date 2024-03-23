import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function LoginComponent() {
    const [username, setUsername] = useState('Ujjawal')
    const [password, setPassword] = useState('')
    const [showSuccessMsg, setShowSuccessMsg] = useState(false)
    const [showErrorMsg, setShowErrorMsg] = useState(false)

    const navigate = useNavigate();

    function handleUsernameChange(event) {
        setUsername(event.target.value)
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value)
    }

    function handleSubmit() {
        if (username === 'Ujjawal' && password === '123') {
            setShowSuccessMsg(true)
            setShowErrorMsg(false)
            navigate(`/welcome/${username}`)
        }
        else {
            setShowSuccessMsg(false)
            setShowErrorMsg(true)
        }
    }

    return (
        <div className="Login">
            <div className="LoginForm">
                {showSuccessMsg && <div className='sucessMessage'>Authenticated Successfully</div>}
                {showErrorMsg && <div className='errorMessage'>Authenticated Failed. Please check creds.</div>}
                <div>
                    <label>Username</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    )
}
