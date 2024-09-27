import React, { useState } from 'react';
import { DragDrop } from './components/DragDrop';
import { ThemeProvider } from './theme';

interface FileDetails {
    name: string;
    size: number;
}

const App: React.FC = () => {
    const [folder1Files, setFolder1Files] = useState<FileDetails[]>([]);
    const [folder2Files, setFolder2Files] = useState<FileDetails[]>([]);

    const formatSize = (size: number) => `${(size / 1024).toFixed(2)} KB`; // Convert size to KB

    return (
        <ThemeProvider>
            <div className="app">
                <h1>Folder Diff</h1>
                <div className="dropzones">
                    <DragDrop label="Folder/Zip 1" onFilesDrop={setFolder1Files} />
                    <DragDrop label="Folder/Zip 2" onFilesDrop={setFolder2Files} />
                </div>

                <div className="results">
                    <h3>Folder 1 Files:</h3>
                    {folder1Files.length > 0 ? (
                        <ul>
                            {folder1Files.map((file, index) => (
                                <li key={index}>
                                    {file.name} - {formatSize(file.size)}
                                </li>
                            ))}
                        </ul>
                    ) : (
                        <p>No files dropped in Folder 1.</p>
                    )}

                    <h3>Folder 2 Files:</h3>
                    {folder2Files.length > 0 ? (
                        <ul>
                            {folder2Files.map((file, index) => (
                                <li key={index}>
                                    {file.name} - {formatSize(file.size)}
                                </li>
                            ))}
                        </ul>
                    ) : (
                        <p>No files dropped in Folder 2.</p>
                    )}

                    {/* TODO: Implement diff calculation logic */}
                </div>
            </div>
        </ThemeProvider>
    );
};

export default App;
