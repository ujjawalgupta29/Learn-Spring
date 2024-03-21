import FirstComponent from './FirstComponent';
import SecondComponent from './SecondComponent';
import ThirdComponent from './ThirdComponent';
import FourthComponent from './FourthComponent';
//To import componenet that is not default -> anmed import
import { FifthComponent } from './FirstComponent';
import LearningJavaScript from './LearningJavaScript';

export default function LearningComponent() {
    return (
        <>
            <FirstComponent/>
            <SecondComponent/>
            <ThirdComponent/>
            <FourthComponent/>
            <FifthComponent/>
            <LearningJavaScript/>
        </>
    );
  }