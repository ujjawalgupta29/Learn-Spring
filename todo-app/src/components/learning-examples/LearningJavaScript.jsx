const person = {
    name: 'Ujjawal',
    address: {
        line1: 'Baker Street',
        city: 'London',
        country: 'UK'
    },
    profiles: ['twitter', 'linkedin', 'instagram'],
    printProfile: () => {
        person.profiles.map(
            (profile) => {
                console.log(profile)
            }
        )
    }
}

export default function LearningJavaScript() {
    return (
        <div>
            Learning JavaScript
            <div>{person.name}</div>
            <div>{person.address.line1}</div>
            <div>{person.address.city}</div>
            <div>{person.address.country}</div>
            <div>{person.profiles[0]}</div>
            <div>{person.printProfile()}</div>
        </div>
    );
}