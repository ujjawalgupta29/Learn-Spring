import { useParams, Link } from 'react-router-dom';

export default function WelcomeComponent() {

    const { username } = useParams()
    return (
        <div className='Welcome'>
            Welcome {username}
            <div>
                {/* Manage Your Todos <a href='/todos'>here.</a> render page again */}
                Manage Your Todos <Link to='/todos'>here.</Link>
            </div>
        </div>
    )
}

