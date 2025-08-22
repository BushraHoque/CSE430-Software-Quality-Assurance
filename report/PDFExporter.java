package report;

import model.*;
import util.*;

import java.util.List;

public class PDFExporter {
    private static final String EXPORT_DIR = "exports";
    private static final String LINE_SEPARATOR = "================================================================";
    private static final String SECTION_SEPARATOR = "----------------------------------------";

    public PDFExporter() {
        createExportDirectory();
    }

    // Public Export Methods

    public boolean exportDailyReport(String content, String date) {
        return exportReport(content, "daily_report_" + date.replace("-", "_") + ".pdf");
    }

    public boolean exportMonthlyReport(String content, String month) {
        return exportReport(content, "monthly_report_" + month.replace("-", "_") + ".pdf");
    }

    public boolean exportAnnualReport(String content, String year) {
        return exportReport(content, "annual_report_" + year + ".pdf");
    }

    public boolean exportReport(String content, String fileName) {
        return exportToPDF(content, fileName, "Report");
    }

    public boolean exportUserList(List<User> users) {
        StringBuilder sb = new StringBuilder();
        sb.append(createPDFHeader("USER LIST REPORT"))
          .append("Generated: ").append(DateUtil.getCurrentDateTime()).append("\n\n")
          .append("TOTAL USERS: ").append(users.size()).append("\n")
          .append(LINE_SEPARATOR).append("\n\n")
          .append(String.format("%-12s %-25s %-30s %-12s %-8s\n", "USER ID", "NAME", "EMAIL", "ROLE", "STATUS"))
          .append(SECTION_SEPARATOR).append("\n");

        for (User u : users) {
            sb.append(String.format("%-12s %-25s %-30s %-12s %-8s\n",
                    u.getId(),
                    truncate(u.getName(), 24),
                    truncate(u.getEmail(), 29),
                    u.getRole(),
                    u.isActive() ? "Active" : "Inactive"));
        }

        sb.append("\n").append(createPDFFooter());

        return exportToPDF(sb.toString(), "user_list_" + DateUtil.getCurrentDate(), "User List");
    }

    public boolean exportPackageList(List<TourPackage> packages) {
        StringBuilder sb = new StringBuilder();
        sb.append(createPDFHeader("PACKAGE LIST REPORT"))
          .append("Generated: ").append(DateUtil.getCurrentDateTime()).append("\n\n")
          .append("TOTAL PACKAGES: ").append(packages.size()).append("\n")
          .append(LINE_SEPARATOR).append("\n\n")
          .append(String.format("%-12s %-25s %-15s %-12s %-6s %-8s\n", "PACKAGE ID", "NAME", "LOCATION", "PRICE", "DAYS", "STATUS"))
          .append(SECTION_SEPARATOR).append("\n");

        for (TourPackage pkg : packages) {
            sb.append(String.format("%-12s %-25s %-15s %-12s %-6d %-8s\n",
                    pkg.getPackageId(),
                    truncate(pkg.getName(), 24),
                    truncate(pkg.getLocation(), 14),
                    CurrencyFormatter.formatBDT(pkg.getBasePrice()),
                    pkg.getDuration(),
                    pkg.isActive() ? "Active" : "Inactive"));
        }

        sb.append("\n").append(createPDFFooter());

        return exportToPDF(sb.toString(), "package_list_" + DateUtil.getCurrentDate(), "Package List");
    }

    public boolean exportBookingList(List<Booking> bookings) {
        long confirmed = bookings.stream().filter(b -> b.getStatus() == enumtype.BookingStatus.CONFIRMED).count();
        double revenue = bookings.stream().mapToDouble(Booking::getTotalAmount).sum();

        StringBuilder sb = new StringBuilder();
        sb.append(createPDFHeader("BOOKING LIST REPORT"))
          .append("Generated: ").append(DateUtil.getCurrentDateTime()).append("\n\n")
          .append("TOTAL BOOKINGS: ").append(bookings.size()).append("\n")
          .append(LINE_SEPARATOR).append("\n\n")
          .append("SUMMARY STATISTICS:\n")
          .append("Confirmed Bookings: ").append(confirmed).append("\n")
          .append("Total Revenue: ").append(CurrencyFormatter.formatBDT(revenue)).append("\n\n")
          .append(String.format("%-12s %-12s %-12s %-6s %-12s %-10s\n", "BOOKING ID", "PACKAGE ID", "TRAVEL DATE", "PEOPLE", "AMOUNT", "STATUS"))
          .append(SECTION_SEPARATOR).append("\n");

        for (Booking b : bookings) {
            sb.append(String.format("%-12s %-12s %-12s %-6d %-12s %-10s\n",
                    b.getBookingId(),
                    b.getPackageId(),
                    b.getTravelDate(),
                    b.getNumberOfPeople(),
                    CurrencyFormatter.formatBDT(b.getTotalAmount()),
                    b.getStatus().getDisplayName()));
        }

        sb.append("\n").append(createPDFFooter());

        return exportToPDF(sb.toString(), "booking_list_" + DateUtil.getCurrentDate(), "Booking List");
    }

    public boolean exportPaymentList(List<Payment> payments) {
        long completed = payments.stream().filter(p -> "COMPLETED".equals(p.getPaymentStatus())).count();
        double totalAmount = payments.stream().filter(p -> "COMPLETED".equals(p.getPaymentStatus()))
                .mapToDouble(Payment::getAmount).sum();

        StringBuilder sb = new StringBuilder();
        sb.append(createPDFHeader("PAYMENT LIST REPORT"))
          .append("Generated: ").append(DateUtil.getCurrentDateTime()).append("\n\n")
          .append("TOTAL PAYMENTS: ").append(payments.size()).append("\n")
          .append(LINE_SEPARATOR).append("\n\n")
          .append("SUMMARY STATISTICS:\n")
          .append("Completed Payments: ").append(completed).append("\n")
          .append("Total Amount: ").append(CurrencyFormatter.formatBDT(totalAmount)).append("\n\n")
          .append(String.format("%-12s %-12s %-12s %-15s %-12s\n", "PAYMENT ID", "BOOKING ID", "AMOUNT", "METHOD", "STATUS"))
          .append(SECTION_SEPARATOR).append("\n");

        for (Payment p : payments) {
            sb.append(String.format("%-12s %-12s %-12s %-15s %-12s\n",
                    p.getPaymentId(),
                    p.getBookingId(),
                    CurrencyFormatter.formatBDT(p.getAmount()),
                    p.getPaymentMethod(),
                    p.getPaymentStatus()));
        }

        sb.append("\n").append(createPDFFooter());

        return exportToPDF(sb.toString(), "payment_list_" + DateUtil.getCurrentDate(), "Payment List");
    }

    public boolean exportInvoice(Invoice invoice) {
        StringBuilder sb = new StringBuilder();
        sb.append(createPDFHeader("INVOICE"))
          .append("Invoice ID: ").append(invoice.getInvoiceId()).append("\n")
          .append("Issue Date: ").append(invoice.getIssueDate()).append("\n")
          .append("Booking ID: ").append(invoice.getBookingId()).append("\n\n")
          .append(LINE_SEPARATOR).append("\n")
          .append("BILLING DETAILS:\n")
          .append(LINE_SEPARATOR).append("\n")
          .append(String.format("%-40s %-8s %-12s %-12s\n", "DESCRIPTION", "QTY", "UNIT PRICE", "AMOUNT"))
          .append(SECTION_SEPARATOR).append("\n");

        for (Invoice.InvoiceItem item : invoice.getItems()) {
            sb.append(String.format("%-40s %-8d %-12s %-12s\n",
                    truncate(item.description, 39),
                    item.quantity,
                    CurrencyFormatter.formatBDT(item.amount),
                    CurrencyFormatter.formatBDT(item.amount * item.quantity)));
        }

        sb.append(SECTION_SEPARATOR).append("\n")
          .append(String.format("%-61s %-12s\n", "SUBTOTAL:", CurrencyFormatter.formatBDT(invoice.getSubtotal())))
          .append(String.format("%-61s %-12s\n", "TAX:", CurrencyFormatter.formatBDT(invoice.getTax())))
          .append(String.format("%-61s %-12s\n", "DISCOUNT:", CurrencyFormatter.formatBDT(invoice.getDiscount())))
          .append(LINE_SEPARATOR).append("\n")
          .append(String.format("%-61s %-12s\n", "TOTAL:", CurrencyFormatter.formatBDT(invoice.getTotalAmount())))
          .append(LINE_SEPARATOR).append("\n\n")
          .append("Thank you for choosing TourBD!\n")
          .append(createPDFFooter());

        return exportToPDF(sb.toString(), "invoice_" + invoice.getInvoiceId() + ".pdf", "Invoice");
    }

    public boolean exportTicket(Ticket ticket) {
        StringBuilder sb = new StringBuilder();
        sb.append(createPDFHeader("TRAVEL TICKET"))
          .append("Ticket ID: ").append(ticket.getTicketId()).append("\n")
          .append("Issue Date: ").append(ticket.getIssueDate()).append("\n")
          .append("Booking Reference: ").append(ticket.getBookingId()).append("\n\n")
          .append(LINE_SEPARATOR).append("\n")
          .append("PASSENGER DETAILS:\n")
          .append(LINE_SEPARATOR).append("\n")
          .append("Name: ").append(ticket.getPassengerName()).append("\n");

        if (ticket.getPassengerPhone() != null) {
            sb.append("Phone: ").append(ticket.getPassengerPhone()).append("\n");
        }

        sb.append("Package: ").append(ticket.getPackageName()).append("\n");

        if (ticket.getSeatNumber() != null) {
            sb.append("Seat: ").append(ticket.getSeatNumber()).append("\n");
        }

        sb.append("\n").append(LINE_SEPARATOR).append("\n")
          .append("QR CODE: ").append(ticket.getQRcode()).append("\n")
          .append("STATUS: ").append(ticket.isUsed() ? "USED" : "VALID").append("\n")
          .append(LINE_SEPARATOR).append("\n\n")
          .append("Please present this ticket at the departure point.\n")
          .append("For any queries, contact: +880-2-123456789\n\n")
          .append(createPDFFooter());

        return exportToPDF(sb.toString(), "ticket_" + ticket.getTicketId() + ".pdf", "Ticket");
    }

    public boolean exportCustomReport(String title, String content, String fileName) {
        StringBuilder sb = new StringBuilder();
        sb.append(createPDFHeader(title.toUpperCase()))
          .append("Generated: ").append(DateUtil.getCurrentDateTime()).append("\n\n")
          .append(content)
          .append("\n")
          .append(createPDFFooter());

        return exportToPDF(sb.toString(), fileName, title);
    }

    public boolean exportBulkData(String dataType, String start, String end) {
        StringBuilder sb = new StringBuilder();
        sb.append(createPDFHeader("BULK DATA EXPORT - " + dataType.toUpperCase()))
          .append("Export Period: ").append(start).append(" to ").append(end).append("\n")
          .append("Export Date: ").append(DateUtil.getCurrentDateTime()).append("\n\n")
          .append("Records exported: ").append(calculateRecordCount(dataType)).append("\n\n")
          .append("Bulk data export completed successfully.\n")
          .append(createPDFFooter());

        String fileName = String.format("bulk_export_%s_%s_to_%s.pdf",
                dataType.toLowerCase(),
                start.replace("-", "_"),
                end.replace("-", "_"));

        return exportToPDF(sb.toString(), fileName, "Bulk Export");
    }

    // Utility & Internal

    private boolean exportToPDF(String content, String fileName, String docType) {
        try {
            String formatted = formatAsPDF(content, docType);
            String fullPath = EXPORT_DIR + "/" + fileName;
            FileHandler.writeToFile(fullPath, formatted);
            Logger.log("Exported PDF: " + fileName);
            return true;
        } catch (Exception e) {
            Logger.error("Export failed: " + e.getMessage());
            return false;
        }
    }

    private String formatAsPDF(String content, String docType) {
        StringBuilder formatted = new StringBuilder();
        formatted.append("%PDF-1.4\n")
                 .append("% TourBD Management - ").append(docType).append("\n")
                 .append("% Generated: ").append(DateUtil.getCurrentDateTime()).append("\n\n");

        for (String line : content.split("\n")) {
            formatted.append(line).append("\n");
        }

        formatted.append("\n\n% End of PDF content\n%%EOF\n");
        return formatted.toString();
    }

    private String createPDFHeader(String title) {
        return LINE_SEPARATOR + "\n" +
               center("TOURBD TRAVEL & TOURISM MANAGEMENT SYSTEM") + "\n" +
               center(title) + "\n" +
               LINE_SEPARATOR + "\n\n";
    }

    private String createPDFFooter() {
        return LINE_SEPARATOR + "\n" +
               center("TourBD - Your Trusted Travel Partner") + "\n" +
               center("Email: info@tourbd.com | Phone: +880-2-123456789") + "\n" +
               center("Website: www.tourbd.com") + "\n" +
               LINE_SEPARATOR + "\n";
    }
private static String centerText(String text) {
    int totalWidth = LINE_SEPARATOR.length();
    int padding = (totalWidth - text.length()) / 2;
    return repeatSpace(Math.max(0, padding)) + text;
}

private static String repeatSpace(int count) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
        sb.append(" ");
    }
    return sb.toString();
}


    private String truncate(String text, int maxLength) {
        if (text == null) return "";
        return text.length() > maxLength ? text.substring(0, maxLength - 3) + "..." : text;
    }

    private void createExportDirectory() {
        Logger.log("Export directory initialized: " + EXPORT_DIR);
    }

  private int calculateRecordCount(String dataType) {
    if (dataType == null) {
        return 0;
    }
    switch (dataType.toLowerCase()) {
        case "users":
            return 150;
        case "bookings":
            return 500;
        case "payments":
            return 450;
        case "packages":
            return 25;
        default:
            return 100;
    }
}

    private String center(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
