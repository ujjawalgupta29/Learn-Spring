
import './App.css';
import Counter from './components/counter/Counter';
// import LearningComponent from './components/learning-examples/LearningComponent';

function App() {
  return (
    <div className="App">
      <Counter/>
      <Counter by={2}/>
      <Counter by={5}/>
      {/* <Counter by="10"/> will throw warning as prop type doesn't match, expected a number */}
    </div>
  );
}

export default App;
