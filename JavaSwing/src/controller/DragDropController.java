package controller;

import javax.swing.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.File;
import java.util.List;
import model.FolderDiff;

public class DragDropController {
    public DragDropController(JPanel panel1, JPanel panel2, JTextArea resultArea) {
        DropTargetListener listener = new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent event) {
                try {
                    event.acceptDrop(DnDConstants.ACTION_COPY);
                    Transferable transferable = event.getTransferable();
                    List<File> droppedFiles = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);

                    for (File file : droppedFiles) {
                        if (file.isDirectory()) {
                            // Clear the result area before starting a new scan
                            resultArea.setText("Scanning " + file.getName() + "...\n");

                            // Perform folder scan asynchronously using SwingWorker
                            new FolderScanWorker(file, resultArea).execute();
                        } else {
                            resultArea.append("Error: Please drop a folder.\n");
                        }
                    }
                    event.dropComplete(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new DropTarget(panel1, listener);
        new DropTarget(panel2, listener);
    }

    // SwingWorker class for async folder scan
    private static class FolderScanWorker extends SwingWorker<Void, String> {
        private File folder;
        private JTextArea resultArea;

        public FolderScanWorker(File folder, JTextArea resultArea) {
            this.folder = folder;
            this.resultArea = resultArea;
        }

        @Override
        protected Void doInBackground() throws Exception {
            List<String> scanResults = FolderDiff.scanFolder(folder, 0);
            for (String result : scanResults) {
                publish(result); // Sends data to the process() method for UI update
            }
            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            for (String chunk : chunks) {
                resultArea.append(chunk + "\n");
            }
        }

        @Override
        protected void done() {
            resultArea.append("Scan complete.\n");
        }
    }
}
