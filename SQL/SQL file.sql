Select feedback_comments from feedback
join recipient
on feedback.RecipientID = recipient.RecipientID
where recipient.RecipientGender = 'M';

-- 2. Average donation quantity for each state--
select state, avg(AvailableQuantity) over (partition by state)
from location;

Select state, avg(availablequantity) as average_donation_quantity from location
group by state;

-- 3. how many stem cell donors in each city--
Select city, sum(donorid) as Total_number_donors from stemcelldonation
join location
where stemcelldonation.LocationID = location.LocationID
group by city;

select location.city, count(donor.DonorID) as numberofstemcells
from donor
join location on donor.LocationID = location.LocationID
where donor.DonatedItem = 'StemCell'
group by location.city;

-- 4.  How many plasma donors in each state --
Select state, sum(donorid) as Total_plasma_donors from plasmadonation
join location
where plasmadonation.LocationID = location.LocationID
group by state;

-- 5. List all blood quantity and type by location --
Select LocationID as Location, availablequantity as Blood_quantity, Bloodtype from location
group by LocationID;

-- 6. List of donors for locations which have more than 4 quantities of blood requested --
Select Donorid as donors, donor.LocationID, request.NoofBags, request.BloodGroup from donor
join request
on donor.LocationID = request.LocationID 
where request.NoofBags > 4
group by request.LocationID;

select l.locationname , l.city , l.state,  d.donorname, d.donorcontactnumber , r.requesteditem, r.noofbags as RequestedQuantity
from location l 
join request r on l.locationID = r.locationID
join donor d on l.LocationID = d.LocationID
where r.RequestedItem = 'Bloodbag' and r.noofbags > 4
order by l.LocationName, d.donorname;

-- Give the second top most donor in every location --
Select d.DonorID, d.DonationQuantity, d.DonorName, l.LocationID 
from donor d
join location l
where d.LocationID = l.LocationID
order by d.donationQuantity limit 1 offset;

-- Write a stored function to fetch all the donor details when a donor ID 324351  is fetched --
Delimiter //
Create procedure Getdonordetails (IN donor_id varchar (6))
begin
select * from donor
where donorID = donor_id;
end //
Delimiter ;

Call Getdonordetails('324351');





