package entity;

public class Ticket {

    private String shippingCompany;
    private String departureTime;
    private String arrivalTime;

    private String departureAirport;
    private String arrivalAirport;
    private String flightTimeDuration;

    public Ticket(String shippingCompany, String departureTime, String arrivalTime,
                  String departureAirport, String arrivalAirport, String flightTimeDuration) {
        this.shippingCompany = shippingCompany;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;

        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightTimeDuration = flightTimeDuration;
    }

    public Ticket() {
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAeroport) {
        this.departureAirport = departureAeroport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAeroport) {
        this.arrivalAirport = arrivalAeroport;
    }

    public String getFlightTimeDuration() {
        return flightTimeDuration;
    }

    public void setFlightTimeDuration(String flightTimeDuration) {
        this.flightTimeDuration = flightTimeDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (getShippingCompany() != null ? !getShippingCompany().equals(ticket.getShippingCompany()) : ticket.getShippingCompany() != null)
            return false;
        if (getDepartureTime() != null ? !getDepartureTime().equals(ticket.getDepartureTime()) : ticket.getDepartureTime() != null)
            return false;
        if (getArrivalTime() != null ? !getArrivalTime().equals(ticket.getArrivalTime()) : ticket.getArrivalTime() != null)
            return false;
        if (getDepartureAirport() != null ? !getDepartureAirport().equals(ticket.getDepartureAirport()) : ticket.getDepartureAirport() != null)
            return false;
        if (getArrivalAirport() != null ? !getArrivalAirport().equals(ticket.getArrivalAirport()) : ticket.getArrivalAirport() != null)
            return false;
        return getFlightTimeDuration() != null ? getFlightTimeDuration().equals(ticket.getFlightTimeDuration()) : ticket.getFlightTimeDuration() == null;
    }

    @Override
    public int hashCode() {
        int result = getShippingCompany() != null ? getShippingCompany().hashCode() : 0;
        result = 31 * result + (getDepartureTime() != null ? getDepartureTime().hashCode() : 0);
        result = 31 * result + (getArrivalTime() != null ? getArrivalTime().hashCode() : 0);
        result = 31 * result + (getDepartureAirport() != null ? getDepartureAirport().hashCode() : 0);
        result = 31 * result + (getArrivalAirport() != null ? getArrivalAirport().hashCode() : 0);
        result = 31 * result + (getFlightTimeDuration() != null ? getFlightTimeDuration().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "shippingCompany='" + shippingCompany + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureAiroport='" + departureAirport + '\'' +
                ", arrivalAiroport='" + arrivalAirport + '\'' +
                ", flightTimeDuration='" + flightTimeDuration + '\'' +
                '}';
    }
}
