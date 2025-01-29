import React, { useState } from "react";

const questions = [
  { question: "What does a red traffic light mean?", options: ["Go", "Stop"], answer: "Stop" },
  { question: "Which side should you overtake from in India?", options: ["Left", "Right"], answer: "Right" },
  { question: "Max speed limit for two-wheelers on highways?", options: ["60 km/h", "80 km/h"], answer: "80 km/h" },
];

export default function QuizApp() {
  const [currentQuestion, setCurrentQuestion] = useState(0);
  const [score, setScore] = useState(0);
  const [showResult, setShowResult] = useState(false);

  const handleAnswer = (option) => {
    if (option === questions[currentQuestion].answer) setScore(score + 1);
    if (currentQuestion + 1 < questions.length) {
      setCurrentQuestion(currentQuestion + 1);
    } else {
      setShowResult(true);
    }
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-blue-100 p-4">
      <div className="w-full max-w-md p-6 bg-white shadow-lg rounded-xl text-center">
        {showResult ? (
          <div>
            <h2 className="text-xl font-bold mb-4">Quiz Completed!</h2>
            <p className="text-lg">Your Score: {score} / {questions.length}</p>
            <button onClick={() => window.location.reload()} className="mt-4 px-4 py-2 bg-blue-500 text-white rounded">
              Restart Quiz
            </button>
          </div>
        ) : (
          <div>
            <h2 className="text-lg font-semibold mb-4">{questions[currentQuestion].question}</h2>
            {questions[currentQuestion].options.map((option, index) => (
              <button key={index} onClick={() => handleAnswer(option)} className="w-full px-4 py-2 bg-gray-200 hover:bg-gray-300 rounded mt-2">
                {option}
              </button>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}
