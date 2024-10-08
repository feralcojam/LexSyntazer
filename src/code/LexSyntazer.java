package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

/**
 *
 * @author feralcojam
 */
public class LexSyntazer extends javax.swing.JFrame {
    
    /**
     * Creates new form LexSemanzer
     */
    public LexSyntazer() {
        initComponents();
        txt_input.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "insertTab");
        txt_input.getActionMap().put("insertTab", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_input.insert("    ", txt_input.getCaretPosition());
            }
        });
    }

    private void analyzeLex() throws IOException {
        int count = 1;
        
        String exp = (String) txt_input.getText();
        Lexer lexer = new Lexer(new StringReader(exp));
        String result = "Line" + "\t\t\tSymbol\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txt_lex_output.setText(result);
                return;
            }
            switch (token) {
                case LineBreak:
                    count++;
                    result += "[LineBreak]" + "\n";
                    break;
                case STRING:
                    result += "[ReservedSTRING]\t" + lexer.lexeme + "\n";
                    break;
                case INT:
                    result += "[ReservedINT]\t" + lexer.lexeme + "\n";
                    break;
                case IF:
                    result += "[ReservedIF]\t" + lexer.lexeme + "\n";
                    break;
                case ELSE:
                    result += "[ReservedELSE]\t" + lexer.lexeme + "\n";
                    break;
                case WHILE:
                    result += "[ReservedWHILE]\t" + lexer.lexeme + "\n";
                    break;
                case FOR:
                    result += "[ReservedFOR]\t" + lexer.lexeme + "\n";
                    break;
                case DO:
                    result += "[ReservedDO]\t" + lexer.lexeme + "\n";
                    break;
                case Equal:
                    result += "[OperatorEqual]\t" + lexer.lexeme + "\n";
                    break;
                case GreaterThan:
                    result += "[OperatorGreater]\t" + lexer.lexeme + "\n";
                    break;
                case GreaterEqualThan:
                    result += "[OperatorGreaterEqual]\t" + lexer.lexeme + "\n";
                    break;
                case LessThan:
                    result += "[OperatorLess]\t" + lexer.lexeme + "\n";
                    break;
                case LessEqualThan:
                    result += "[OperatorLessEqual]\t" + lexer.lexeme + "\n";
                    break;
                case Increment:
                    result += "[OperatorIncrement]\t" + lexer.lexeme + "\n";
                    break;
                case Decrement:
                    result += "[OperatorDecrement]\t" + lexer.lexeme + "\n";
                    break;
                case Add:
                    result += "[OperatorAdd]\t" + lexer.lexeme + "\n";
                    break;
                case Subtract:
                    result += "[OperatorSubtract]\t" + lexer.lexeme + "\n";
                    break;
                case Multiplication:
                    result += "[OperatorMultiplication]\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    result += "[OperatorDivision]\t\t" + lexer.lexeme + "\n";
                    break;
                case Modulo:
                    result += "[OperatorModulo]\t\t" + lexer.lexeme + "\n";
                    break;
                case OpenParenthesis:
                    result += "[OpenParenthesis]\t" + lexer.lexeme + "\n";
                    break;
                case CloseParenthesis:
                    result += "[CloseParenthesis]\t" + lexer.lexeme + "\n";
                    break;
                case OpenBrace:
                    result += "[OpenBrace]\t" + lexer.lexeme + "\n";
                    break;
                case CloseBrace:
                    result += "[CloseBrace]\t" + lexer.lexeme + "\n";
                    break;
                case OpenBracket:
                    result += "[OpenBracket]\t" + lexer.lexeme + "\n";
                    break;
                case CloseBracket:
                    result += "[CloseBracket]\t" + lexer.lexeme + "\n";
                    break;
                case Public:
                    result += "[ReservedPublic]\t" + lexer.lexeme + "\n";
                    break;
                case Class:
                    result += "[ReservedClass]\t" + lexer.lexeme + "\n";
                    break;
                case Static:
                    result += "[ReservedStatic]\t" + lexer.lexeme + "\n";
                    break;
                case Void:
                    result += "[ReservedVoid]\t\t" + lexer.lexeme + "\n";
                    break;
                case Args:
                    result += "[ReservedArgs]\t\t" + lexer.lexeme + "\n";
                    break;
                case Main:
                    result += "[ReservedMain]\t\t" + lexer.lexeme + "\n";
                    break;
                case Semicolon:
                    result += "  [Semicolon]\t" + lexer.lexeme + "\n";
                    break;
                case Comma:
                    result += "  [Comma]\t" + lexer.lexeme + "\n";
                    break;
                case Identifier:
                    result += "  [Identifier]\t\t" + lexer.lexeme + "\n";
                    break;
                case Number:
                    result += "  [Number]\t\t" + lexer.lexeme + "\n";
                    break;
                case StringLiteral:
                    result += "  [StringLiteral]\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    result += "  [UndefinedSymbol]\t\t" + lexer.lexeme + "\n";
                    break;
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_panel = new javax.swing.JPanel();
        north_panel = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        open_file_btn = new javax.swing.JLabel();
        south_panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_syn_output = new javax.swing.JTextArea();
        lex_label = new javax.swing.JLabel();
        clear_text_btn2 = new javax.swing.JLabel();
        scan_syn_btn = new javax.swing.JLabel();
        center_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_input = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_lex_output = new javax.swing.JTextArea();
        scan_lex_btn = new javax.swing.JLabel();
        clear_text_btn1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lex_label1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bg_panel.setBackground(new java.awt.Color(240, 240, 240));
        bg_panel.setLayout(new java.awt.BorderLayout());

        north_panel.setBackground(new java.awt.Color(51, 51, 51));

        title_label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title_label.setForeground(new java.awt.Color(255, 255, 255));
        title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_label.setText("LexSyntazer");

        open_file_btn.setBackground(new java.awt.Color(51, 51, 51));
        open_file_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        open_file_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/open_file.png"))); // NOI18N
        open_file_btn.setOpaque(true);
        open_file_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                open_file_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                open_file_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                open_file_btnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout north_panelLayout = new javax.swing.GroupLayout(north_panel);
        north_panel.setLayout(north_panelLayout);
        north_panelLayout.setHorizontalGroup(
            north_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(north_panelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(open_file_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(836, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, north_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        north_panelLayout.setVerticalGroup(
            north_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(north_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_label)
                .addGap(18, 18, 18)
                .addComponent(open_file_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        bg_panel.add(north_panel, java.awt.BorderLayout.PAGE_START);

        south_panel.setBackground(new java.awt.Color(51, 51, 51));

        txt_syn_output.setEditable(false);
        txt_syn_output.setBackground(new java.awt.Color(40, 40, 40));
        txt_syn_output.setColumns(20);
        txt_syn_output.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txt_syn_output.setForeground(new java.awt.Color(51, 153, 0));
        txt_syn_output.setRows(5);
        jScrollPane3.setViewportView(txt_syn_output);

        lex_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lex_label.setForeground(new java.awt.Color(255, 255, 255));
        lex_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lex_label.setText("Analyzer");

        clear_text_btn2.setBackground(new java.awt.Color(51, 51, 51));
        clear_text_btn2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clear_text_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clean.png"))); // NOI18N
        clear_text_btn2.setOpaque(true);
        clear_text_btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear_text_btn2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clear_text_btn2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clear_text_btn2MouseExited(evt);
            }
        });

        scan_syn_btn.setBackground(new java.awt.Color(51, 51, 51));
        scan_syn_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scan_syn_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analyze.png"))); // NOI18N
        scan_syn_btn.setOpaque(true);
        scan_syn_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scan_syn_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scan_syn_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scan_syn_btnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout south_panelLayout = new javax.swing.GroupLayout(south_panel);
        south_panel.setLayout(south_panelLayout);
        south_panelLayout.setHorizontalGroup(
            south_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(south_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(south_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(south_panelLayout.createSequentialGroup()
                        .addGap(0, 173, Short.MAX_VALUE)
                        .addComponent(lex_label, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scan_syn_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clear_text_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addGap(11, 11, 11))
        );
        south_panelLayout.setVerticalGroup(
            south_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(south_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(south_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(clear_text_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lex_label)
                    .addComponent(scan_syn_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        bg_panel.add(south_panel, java.awt.BorderLayout.PAGE_END);

        center_panel.setBackground(new java.awt.Color(51, 51, 51));

        txt_input.setBackground(new java.awt.Color(40, 40, 40));
        txt_input.setColumns(20);
        txt_input.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txt_input.setForeground(new java.awt.Color(51, 153, 0));
        txt_input.setRows(5);
        jScrollPane1.setViewportView(txt_input);

        txt_lex_output.setEditable(false);
        txt_lex_output.setBackground(new java.awt.Color(40, 40, 40));
        txt_lex_output.setColumns(20);
        txt_lex_output.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txt_lex_output.setForeground(new java.awt.Color(51, 153, 0));
        txt_lex_output.setRows(5);
        jScrollPane2.setViewportView(txt_lex_output);

        scan_lex_btn.setBackground(new java.awt.Color(51, 51, 51));
        scan_lex_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scan_lex_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analyze.png"))); // NOI18N
        scan_lex_btn.setOpaque(true);
        scan_lex_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scan_lex_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scan_lex_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scan_lex_btnMouseExited(evt);
            }
        });

        clear_text_btn1.setBackground(new java.awt.Color(51, 51, 51));
        clear_text_btn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clear_text_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clean.png"))); // NOI18N
        clear_text_btn1.setOpaque(true);
        clear_text_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear_text_btn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clear_text_btn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clear_text_btn1MouseExited(evt);
            }
        });

        lex_label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lex_label1.setForeground(new java.awt.Color(255, 255, 255));
        lex_label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lex_label1.setText("Lexical Analyzer");

        javax.swing.GroupLayout center_panelLayout = new javax.swing.GroupLayout(center_panel);
        center_panel.setLayout(center_panelLayout);
        center_panelLayout.setHorizontalGroup(
            center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(center_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(center_panelLayout.createSequentialGroup()
                        .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                            .addComponent(lex_label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(center_panelLayout.createSequentialGroup()
                                .addComponent(scan_lex_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(clear_text_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        center_panelLayout.setVerticalGroup(
            center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(center_panelLayout.createSequentialGroup()
                .addComponent(lex_label1)
                .addGap(13, 13, 13)
                .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(center_panelLayout.createSequentialGroup()
                        .addGroup(center_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scan_lex_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear_text_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bg_panel.add(center_panel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void open_file_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_open_file_btnMouseClicked
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        File file = new File(jfc.getSelectedFile().getAbsolutePath());
        
        try {
            String st = new String(Files.readAllBytes(file.toPath()));
            txt_input.setText(st);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_open_file_btnMouseClicked

    private void scan_lex_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scan_lex_btnMouseClicked
        try {
            analyzeLex();
        } catch (IOException ex) {
            Logger.getLogger(LexSyntazer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scan_lex_btnMouseClicked

    private void scan_syn_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scan_syn_btnMouseClicked
        String st = txt_input.getText();
        Syntax syn = new Syntax(new code.LexerCup(new StringReader(st)));
        
        try {
            syn.parse();
            txt_syn_output.setText("Analysis Successful!");
            txt_syn_output.setForeground(new Color(51,153,0));
        } catch (Exception ex) {
            java_cup.runtime.Symbol sym = syn.getS();
            txt_syn_output.setText("Syntax error in line " + (sym.right + 1) + " column " + (sym.left + 1) + ", message: \"" + sym.value + "\"");
            txt_syn_output.setForeground(Color.RED);
        }
    }//GEN-LAST:event_scan_syn_btnMouseClicked

    private void clear_text_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_text_btn1MouseClicked
        txt_lex_output.setText(null);
    }//GEN-LAST:event_clear_text_btn1MouseClicked

    private void clear_text_btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_text_btn2MouseClicked
        txt_syn_output.setText(null);
    }//GEN-LAST:event_clear_text_btn2MouseClicked

    private void open_file_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_open_file_btnMouseEntered
        open_file_btn.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_open_file_btnMouseEntered

    private void open_file_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_open_file_btnMouseExited
        open_file_btn.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_open_file_btnMouseExited

    private void scan_lex_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scan_lex_btnMouseEntered
        scan_lex_btn.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_scan_lex_btnMouseEntered

    private void scan_lex_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scan_lex_btnMouseExited
        scan_lex_btn.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_scan_lex_btnMouseExited

    private void clear_text_btn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_text_btn1MouseEntered
        clear_text_btn1.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_clear_text_btn1MouseEntered

    private void clear_text_btn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_text_btn1MouseExited
        clear_text_btn1.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_clear_text_btn1MouseExited

    private void scan_syn_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scan_syn_btnMouseEntered
        scan_syn_btn.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_scan_syn_btnMouseEntered

    private void scan_syn_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scan_syn_btnMouseExited
        scan_syn_btn.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_scan_syn_btnMouseExited

    private void clear_text_btn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_text_btn2MouseEntered
        clear_text_btn2.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_clear_text_btn2MouseEntered

    private void clear_text_btn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_text_btn2MouseExited
        clear_text_btn2.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_clear_text_btn2MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LexSyntazer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LexSyntazer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LexSyntazer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LexSyntazer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LexSyntazer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_panel;
    private javax.swing.JPanel center_panel;
    private javax.swing.JLabel clear_text_btn1;
    private javax.swing.JLabel clear_text_btn2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lex_label;
    private javax.swing.JLabel lex_label1;
    private javax.swing.JPanel north_panel;
    private javax.swing.JLabel open_file_btn;
    private javax.swing.JLabel scan_lex_btn;
    private javax.swing.JLabel scan_syn_btn;
    private javax.swing.JPanel south_panel;
    private javax.swing.JLabel title_label;
    private javax.swing.JTextArea txt_input;
    private javax.swing.JTextArea txt_lex_output;
    private javax.swing.JTextArea txt_syn_output;
    // End of variables declaration//GEN-END:variables
}
