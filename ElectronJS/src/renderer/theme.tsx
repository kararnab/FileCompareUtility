import React, { useState, useEffect, createContext, useContext, ReactNode } from 'react';

// Define the type for the context
interface ThemeContextType {
    toggleTheme: () => void;
}

// Provide a default value that matches the context type
const ThemeContext = createContext<ThemeContextType>({ toggleTheme: () => {} });

interface ThemeProviderProps {
    children: ReactNode; // This defines the type for the children prop
}

export const ThemeProvider: React.FC<ThemeProviderProps> = ({ children }) => {
    // Set the type for the theme state
    const [theme, setTheme] = useState<'light' | 'dark'>('light');

    const toggleTheme = () => {
        setTheme((prevTheme) => (prevTheme === 'light' ? 'dark' : 'light'));
    };

    useEffect(() => {
        document.body.className = theme;
    }, [theme]);

    return (
        <ThemeContext.Provider value={{ toggleTheme }}>
            <button onClick={toggleTheme}>
                Toggle {theme === 'light' ? 'Dark' : 'Light'} Mode
            </button>
            {children}
        </ThemeContext.Provider>
    );
};

// Custom hook to use the theme context
export const useTheme = () => useContext(ThemeContext);
