import { useState } from 'react';
import {BrowserRouter, Routes, Route, useNavigate, useParams} from 'react-router-dom';
import './TodoApp.css';

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<LoginComponent/>}></Route>
                    <Route path='/login' element={<LoginComponent/>}></Route>
                    <Route path='/welcome/:username' element={<WelcomeComponent/>}></Route>
                    <Route path='*' element={<ErrorComponent/>}></Route>
                </Routes>
            </BrowserRouter>
        </div>
    )
}

function LoginComponent() {
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
        if(username === 'Ujjawal' && password === '123') {
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

function WelcomeComponent() {

    const {username} = useParams()
    return (
        <div className='Welcome'>
            Welcome {username}
        </div>
    )
}

function ErrorComponent() {
    return (
        <div className='ErrorComponnet'>
            <h1>We are working hard!</h1>
            <div>
                404
            </div>
        </div>
    )
}