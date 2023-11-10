class Patient {
    private String name;
    private String patientId;

    public Patient(String name, String patientId) {
        this.name = name;
        this.patientId = patientId;
    }

    public String getName() {
        return this.name;
    }

    public String getPatientId() {
        return this.patientId;
    }
}