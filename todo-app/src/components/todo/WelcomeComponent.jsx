import { useParams, Link } from 'react-router-dom';
import { useState } from 'react';
import { retrieveHelloWorldBean, retrieveHelloWorldPathVariable } from './api/HelloWorldApiService';

export default function WelcomeComponent() {

    const { username } = useParams()

    const [message, setMessage] = useState(null);

    function callHelloWorldApi() {
        retrieveHelloWorldPathVariable('Ujju1')
        .then((response) => successfulResponse(response))
        .catch((error) => errorResponse(error))
        .finally(() => console.log('cleanup'));
    }

    function successfulResponse(response) {
        setMessage(response.data.message)
    }

    function errorResponse(error) {
        console.log(error)
    }

    return (
        <div className='Welcome'>
            Welcome {username}
            <div>
                {/* Manage Your Todos <a href='/todos'>here.</a> render page again */}
                Manage Your Todos <Link to='/todos'>here.</Link>
            </div>
            <div>
                <button className='btn btn-success m-5' onClick={callHelloWorldApi}>Call Hello World API</button>
            </div>
            <div className='text-info'>
                {message}
            </div>
        </div>
    )
}

