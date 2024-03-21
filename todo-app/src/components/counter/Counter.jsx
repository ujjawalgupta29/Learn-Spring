import './Counter.css';
export default function Counter() {

//     const buttonStyle = {fontSize: "15px",
// backgroundColor: "#00a5ab",
// width: "100px",
// margin: "10px",
// color: "white",
// padding: "15px",
// borderRadius: "30px"
// }

    function increamentCounterFunction() {
        console.log('increment clicked');
    }
    return (
        <div className="Counter">
            <span className="count">0</span>
            <div>
                <button className="counterButton" onClick={increamentCounterFunction}
                    // style={ buttonStyle }
                >+1</button>
            </div>
        </div>
    );
}