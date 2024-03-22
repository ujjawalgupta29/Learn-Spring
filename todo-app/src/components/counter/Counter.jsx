import { useState } from 'react';
import './Counter.css';
import {PropTypes} from 'prop-types';

export default function Counter({by}) {

    const [count, setCount] = useState(0);

    function incrementCounterFunction() {
        setCount(count + by)
    }

    function decrementCounterFunction() {
        setCount(count - by)
    }

    return (
        <div className="Counter">
            <span className="count">{count}</span>
            <div>
                <button className="counterButton" onClick={incrementCounterFunction}
                // style={ buttonStyle }
                >+{by}</button>

                <button className="counterButton" onClick={decrementCounterFunction}
                >-{by}</button>
            </div>
        </div>
    );
}

Counter.propTypes = {
    by: PropTypes.number //to support only numbers
}

Counter.defaultProps = {
    by: 1
}