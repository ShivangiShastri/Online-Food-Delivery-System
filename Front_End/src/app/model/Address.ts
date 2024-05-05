export class Address{
    addressId: number;
    buildingName: string;
    area: string;
    streetNo: string;
    city:string;
    state:string;
    country: string;
    pincode: string;

    constructor(addressId: number, buildingName: string, area: string, streetNo: string, city: string, state: string, country:string, pincode:string){
        this.addressId=addressId;
        this.buildingName=buildingName;
        this.area=area;
        this.streetNo=streetNo;
        this.city=city;
        this.state=state;
        this.country=country;
        this.pincode=pincode;
    }
}