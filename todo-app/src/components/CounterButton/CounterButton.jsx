import { PropTypes } from 'prop-types';
import './CounterButton.css';

export default function CounterButton({ by, incrementMethod }) {

    return (
        <div className="CounterButton">
            
            <div>
                <button className="counterButton" onClick={() => incrementMethod(by)}
                // style={ buttonStyle }
                >+{by}</button>

                <button className="counterButton" onClick={() => incrementMethod(-by)}
                >-{by}</button>
            </div>
        </div>
    );
}

CounterButton.propTypes = {
    by: PropTypes.number //to support only numbers
}

CounterButton.defaultProps = {
    by: 1
}