import React, { useCallback } from 'react';

interface DragDropProps {
    label: string;
    onFilesDrop: (files: { name: string, size: number, lastModified: number }[]) => void;
}

export const DragDrop: React.FC<DragDropProps> = ({ label, onFilesDrop }) => {
    const onDrop = useCallback((e: React.DragEvent<HTMLDivElement>) => {
        e.preventDefault();
        const droppedFiles = Array.from(e.dataTransfer.files);
        const filesDetails = droppedFiles.map(file => ({
            name: file.name,
            size: file.size,
            lastModified: file.lastModified
        }));
        onFilesDrop(filesDetails); // Pass file details to the parent
    }, [onFilesDrop]);

    return (
        <div
            className="dropzone"
            onDragOver={(e) => e.preventDefault()}
            onDrop={onDrop}
        >
            <p>Drag and Drop {label} here</p>
        </div>
    );
};
