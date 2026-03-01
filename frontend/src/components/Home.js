import React, { useState } from "react";

function Home() {
  const [advice, setAdvice] = useState("");

  const handleGetAdvice = async () => {
    // TODO: Call your backend AI endpoint here.
    // For now, we just set a placeholder text.
    setAdvice(
      "Example AI response: Based on your skills and interests, consider learning React, building 2–3 portfolio projects, and applying for an internship in a software company."
    );
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-slate-100">
      <div className="w-full max-w-2xl bg-white rounded-xl shadow-lg p-8">
        <h1 className="text-2xl font-bold text-slate-800 mb-2">
          Career Advice
        </h1>
        <p className="text-sm text-slate-500 mb-4">
          Click the button below to request AI-powered career advice.
        </p>

        <button
          onClick={handleGetAdvice}
          className="mb-4 px-4 py-2 bg-blue-600 hover:bg-blue-700 text-white font-semibold rounded-lg text-sm shadow-md transition-colors"
        >
          Get Career Advice
        </button>

        <div>
          <label
            htmlFor="advice"
            className="block text-sm font-medium text-slate-700 mb-1"
          >
            AI Response
          </label>
          <textarea
            id="advice"
            className="w-full min-h-[160px] px-3 py-2 border border-slate-300 rounded-lg text-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
            value={advice}
            onChange={(e) => setAdvice(e.target.value)}
            placeholder="AI advice will appear here..."
          />
        </div>
      </div>
    </div>
  );
}

export default Home;
