package notepad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class replaceJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private static boolean isopen = false;
	/**
	 * Launch the application.
	 */
	public static boolean getisopen()
	{
		return isopen;
	}
	public static void main(String[] args) {
		try {
			replaceJDialog dialog = new replaceJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public replaceJDialog() {
		setBounds(100, 100, 585, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCha = new JLabel("查找内容：");
		lblCha.setBounds(39, 48, 88, 18);
		contentPanel.add(lblCha);
		
		JLabel label = new JLabel("替换为：");
		label.setBounds(39, 79, 72, 18);
		contentPanel.add(label);
		
		textField = new JTextField();
		textField.setBounds(121, 45, 209, 24);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 79, 209, 24);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("查找下一个");
		button.setBounds(390, 44, 113, 27);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("替换");
		button_1.setBounds(390, 84, 113, 27);
		contentPanel.add(button_1);
		
		JButton button_2 = new JButton("全部替换");
		button_2.setBounds(390, 124, 113, 27);
		contentPanel.add(button_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
